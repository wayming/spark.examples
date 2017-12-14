FROM ubuntu

# Environment
RUN apt-get update
RUN apt-get install sudo
RUN echo "%sudo        ALL=(ALL)       NOPASSWD: ALL" > /etc/sudoers.d/sandbox
# Need to update again, otherwise fails to install libcurl3-gnutls_7.47.0-1ubuntu2.4_amd64.deb
RUN apt-get update

# Tools
RUN apt-get install -y net-tools
RUN apt-get install -y iputils-ping
RUN apt-get install -y vim

# Setup samba
RUN apt-get install -y samba
RUN echo '[sparkuser]     \n\
   comment = sparkuser    \n\
   path = /home/sparkuser \n\
   browseable = yes       \n\
   read only = no         \n\
   guest ok = yes         \n\
' >> /etc/samba/smb.conf
# Somehow this does not start samba service
# Start later with docker exec command
RUN service smbd restart

RUN apt-get install -y git 
RUN apt-get install -y maven
RUN apt-get install -y openjdk-8-jdk

# SPARK
RUN useradd -m -g sudo sparkuser
USER sparkuser:sudo
WORKDIR /home/sparkuser
RUN pwd

RUN git clone https://github.com/apache/spark.git
RUN pwd
RUN ls -al spark
WORKDIR /home/sparkuser/spark
RUN mvn -DskipTests clean package
