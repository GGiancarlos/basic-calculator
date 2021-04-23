FROM alpine
WORKDIR /root/calculator
COPY /src/Calculator.scala /root/calculator

RUN apk add openjdk8
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin
