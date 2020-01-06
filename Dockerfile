#This is the base.
FROM java:8

#This is the port.
EXPOSE 8017:8017

#No idea
ADD /target/CreditCardJar.jar CreditCardJar.jar

#No idea
ENTRYPOINT ["java", "-jar", "CreditCardJar.jar"]