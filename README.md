# Entwicklungsumgebung und Testausführung
1- Maven muss bereits installiert werden und MAVEN_HOME Pfad gesetzt. Maven Version Apache Maven 3.6.3 ist empfohlen  
2- JAVA JDK 8 installieren und JAVA_HOME Pfad setzen  
3- Docker installieren  
4- Bevor der Testausführung, muss Zalenium Container gepulled werden. Anleitung dafür finden Sie unter diesem Link:
https://opensource.zalando.com/zalenium/  
5- mvn clean package -DskipTests  
6- **Navigieren zum "target" Ordner:** cd target  
7- Kopieren Sie die "application.properties" Datei von "\selenium\src\main\java\com\config" und einfügen unter dem Pfad "target\selenium\src\main\java\com\config". Der Pfad existiert nicht unter dem "target" Ordner, einfach selbst den Pfad erstellen.  
7- **Tests in "RgeressionTest.xml" ausführen:** java -cp "selenium-docker-deichmann.jar:selenium-docker-deichmann-tests.jar:libs/*" org.testng.TestNG ../RegressionSuite.xml  
8- Wenn man das Projekt in einem IDE öffnet, kann man die Test Cases dort ausführen. Einfach rechts Klick auf dem TestNG xml Datei (z.B: RegressionSuite.xml) und dann ausführen als TestNG Test  


# Preconditions for Running the Tests
1- Install Maven, Java and Docker
2- Install Java
3- Run Docker
# Run it!
# Pull docker-selenium
docker pull elgalu/selenium

    # Pull Zalenium
    docker pull dosel/zalenium
    
    # Run it!
    docker run --rm -ti --name zalenium -p 4444:4444 \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/user/videos \
      --privileged dosel/zalenium start
      
    # Point your tests to http://localhost:4444/wd/hub and run them

    # Stop
    docker stop zalenium

4- Access Zalenium Dashboard under this link:
http://localhost:4444/dashboard/

5- Access Zalenium live under this link:
http://localhost:4444/grid/admin/live