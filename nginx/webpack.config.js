const fs = require('fs');
const path = require('path');

const entryMap = {};
fs.readdirSync('./src/js')
.filter(x => x.match(/\.js$/))
.forEach(f => {
  entryMap[f.replace(/\.js$/, '')] = `./src/js${f}`;
});

const proxyPath = (path) => {
  return {
    'context': [path],
    'target': 'http://localhost:8000',
    'headers': {
      'X-Forwarded-Proto': 'https',
      'X-Forwarded-Port': '' + port
    }
  }
}

const port = 8443;
const config = {
  target: ['web', 'es5'],
  entry: entryMap,
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
        }
      }
    ],
  },
  output: {
    filename: '[name].js',
    path: path.join(__dirname, './public/js'),
    publicPath: '/js/'
  },
  resolve: {
    extensions: ['.js']
  },
  optimization: {
    splitChunks: {}
  },
  devServer: {
    host: 'localhost',
    contentBase: 'public',
    port: port,
    https: {
      key: fs.readFileSync('./certs/server.key'),
      cert: fs.readFileSync('./certs/server.crt'),
    },
    proxy: [
        proxyPath('/*')
    ]
  }
}

module.exports = config;
