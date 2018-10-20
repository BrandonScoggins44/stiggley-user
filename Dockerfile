FROM java:8
ADD ./stiggley-user.jar .
EXPOSE 9998
CMD java -jar -Xmx512M stiggley-user.jar
