FROM ubuntu

RUN apt-get update
RUN apt-get install sudo
RUN echo "%sudo        ALL=(ALL)       NOPASSWD: ALL" > /etc/sudoers.d/sandbox
RUN apt-get install -y git maven

RUN useradd -m -R /home/sparkuser -g sudo sparkuser
USER sparkuser:sudo

