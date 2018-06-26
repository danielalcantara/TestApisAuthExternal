FROM maven:3.5.3-jdk-8
MAINTAINER Daniel Alcântara
ENV ENVIRONMENT=desenv
# ENV GATEWAY_REDE_DOCKER='endereço do gateway rede docker' - Verificar 
# o endereço do gateway na rede do container que está rodando o microserviço,
# e setar na variável abaixo, para poder utilizar uma api mockada.
# Utilizar o comando "docker container inspect 'idcontainer'"
ENV GATEWAY_REDE_DOCKER=172.18.0.1
ENV ENV_VARS_ORIGIN=system
ENV CLOUD_SEARCH_ENDPOINT_PROD=
ENV CLOUD_SEARCH_ENDPOINT_HOMOLOGACAO=
ENV CLOUD_SEARCH_ENDPOINT_DESENV=https://avkkxu98a4.execute-api.sa-east-1.amazonaws.com/v1/test-cloud-search
ENV CLOUD_SEARCH_ENDPOINT_MOCK=http://${GATEWAY_REDE_DOCKER}:8989/laudoevolutivo/mock/post
ENV MS_ENDPOINT_FAP_MOCK=http://localhost:8181/laudoevolutivo/fap/{fap}/{qtdLaudos}
ENV MS_ENDPOINT_CIP_MOCK=http://localhost:8181/laudoevolutivo/cip/{cip}/{qtdLaudos}
ENV MS_ENDPOINT_FAP_DESENV=http://localhost:8181//laudoevolutivo/fap/{fap}/{qtdLaudos}
ENV MS_ENDPOINT_CIP_DESENV=http://localhost:8181/laudoevolutivo/cip/{cip}/{qtdLaudos}
ENV MS_ENDPOINT_FAP_HOMOLOGACO=
ENV MS_ENDPOINT_CIP_HOMOLOGACAO=
ENV MS_ENDPOINT_FAP_PROD=
ENV MS_ENDPOINT_CIP_PROD=
ENV HOST_DESENV=avkkxu98a4.execute-api.sa-east-1.amazonaws.com
ENV HOST_HOMOLOGACAO=
ENV HOST_PROD=
ENV TOKEN=
ENV HOME=/root
ENV APPS_FOLDER=/apps
ENV PATH_APPS=${HOME}${APPS_FOLDER}
ADD . ${PATH_APPS}
COPY ./m2/settings.xml ${HOME}/.m2/settings.xml
WORKDIR ${PATH_APPS}
ENTRYPOINT [ "./scripts/buildAndStart.sh" ]
EXPOSE 8181