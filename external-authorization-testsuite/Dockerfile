FROM tomcat:8.5.31-jre8
RUN mkdir -p /opt/vp/app/kharon-external-authorization/config/
COPY external.properties /opt/vp/app/kharon-external-authorization/config/external.properties
COPY target/external-authorization-testsuite-1.0.0.war /usr/local/tomcat/webapps/external-authorization-testsuite.war