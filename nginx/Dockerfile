FROM nginx:stable

ENV LANG ja_JP.UTF-8
ENV Asia/Tokyo

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY default.conf /etc/nginx/default.conf

EXPOSE 80

CMD nginx -g "daemon off;"
