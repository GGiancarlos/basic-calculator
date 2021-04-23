FROM alpine
WORKDIR /root/hello-world
COPY Hello.java /root/hello-world

RUN apk add openjdk8
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin
