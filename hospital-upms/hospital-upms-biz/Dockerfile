FROM wyzy/java:8-jre

MAINTAINER wangiegie@gmail.com

ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-Xms512m -Xmx1024m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /hospital-upms

WORKDIR /hospital-upms

EXPOSE 4000

ADD ./target/hospital-upms-biz.jar ./

CMD sleep 60;java $JAVA_OPTS -jar hospital-upms-biz.jar
