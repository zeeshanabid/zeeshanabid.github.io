FROM golang:latest AS hugo-builder
ENV HUGO_VERSION 0.51
ENV HUGO_DEBIAN hugo_${HUGO_VERSION}_Linux-64bit.deb
WORKDIR /tmp
RUN curl -sLO  https://github.com/gohugoio/hugo/releases/download/v${HUGO_VERSION}/${HUGO_DEBIAN} && \
    dpkg -i ${HUGO_DEBIAN}

COPY . /data
WORKDIR /data
RUN hugo

FROM nginx:alpine
COPY default.nginx /etc/nginx/conf.d/default.conf
COPY --from=hugo-builder /data/public /usr/share/nginx/html
