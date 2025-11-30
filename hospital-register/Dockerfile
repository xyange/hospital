FROM wyzy/java:8-jre

MAINTAINER wangiegie@gmail.com

ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /hospital-register

WORKDIR /hospital-register

EXPOSE 8848

ADD ./target/hospital-register.jar ./

CMD sleep 30;java $JAVA_OPTS -jar hospital-register.jar


