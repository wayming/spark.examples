FROM java:openjdk-8-jdk

ARG spark_ver

ENV spark_ver=$spark_ver

RUN mkdir -p /opt && \
    cd /opt && \
    curl http://www.us.apache.org/dist/spark/spark-${spark_ver}/spark-${spark_ver}-bin-hadoop2.6.tgz | \
        tar -zx && \
    ln -s spark-${spark_ver}-bin-hadoop2.6 spark && \
    echo Spark ${spark_ver} installed in /opt

ADD start-common.sh start-worker.sh start-master.sh /

RUN chmod +x /start-*.sh
