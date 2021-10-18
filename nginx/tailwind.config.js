const colors = require('tailwindcss/defaultConfig').colors;

module.exports = {
  purge: ['./public/**/*.html'],
  darkMode: false, // or 'media' or 'class'
  theme: {
    screens: {
      'sm': {'max': '576px'},
      'lg': {'min': '577px'},
    },
    fontFamily: {
      sans: ['Noto Sans CJK', 'sans-serif']
    },
    extend: {
      colors: {
        bggray: '#F3F3F4',
        green: '#059669'
      },
      spacing: {
        '72': '18rem',
        '84': '21rem',
        '96': '24rem',
        '60px': '60px',
      },
      width: {
        '1000': '1000px',
      }
    }
  }
}
