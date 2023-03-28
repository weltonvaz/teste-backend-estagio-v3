FROM debian:buster

# Instale o Java, Maven e PostgreSQL
RUN apt-get update && \
    apt-get install -y openjdk-11-jdk maven postgresql postgresql-contrib && \
    apt-get clean

# Crie o diretório do projeto e copie o código fonte para dentro dele
RUN mkdir /app
COPY . /app

# Configure o PostgreSQL
USER postgres
RUN /etc/init.d/postgresql start && \
    psql --command "CREATE USER florestal WITH SUPERUSER PASSWORD 'florestal';" && \
    createdb -O florestal florestal

# Configure o ambiente Java
USER root
WORKDIR /app
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]
