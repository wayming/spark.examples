FROM ubuntu

# Environment
RUN apt-get update
RUN apt-get install sudo
RUN echo "%sudo        ALL=(ALL)       NOPASSWD: ALL" > /etc/sudoers.d/sandbox
RUN apt-get install -y git maven openjdk-8-jdk

# SPARK
RUN useradd -m -g sudo sparkuser
USER sparkuser:sudo
RUN git clone https://github.com/apache/spark.git 
WORKDIR ~/spark
RUN mvn -DskipTests clean package

