FROM nginx:stable

ENV LANG ja_JP.UTF-8
ENV TZ Asia/Tokyo

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY yarn.lock /
COPY default.conf /etc/nginx/default.conf
COPY dist /var/nginx/html

EXPOSE 80

CMD nginx -g "daemon off;"
