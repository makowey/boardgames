# Boardgame price collector


To run this application locally just execute the following command:  

`clear && /d/Infrastructure/jdk-11/bin/java -jar /d/Stuff/chilipir/target/chilipir-1.0.0-SNAPSHOT.jar`

## Deploy unmanaged dependencies

`mvn deploy:deploy-file -Durl=file:///D:/Stuff/chilipir/repo -Dfile=lib/jaunt1.6.24.jar -DgroupId=com.jaunt -DartifactId=jaunt -Dpackaging=jar -Dversion=1.6.24`
`mvn clean install -U`

<img src="https://i.pinimg.com/originals/2f/c4/fe/2fc4fee4a8c5ed906bd4fe0286fc309f.png">  

## Angular

`npm install -g @angular/cli`
`npm install --save rxjs-compat`
`ng serve`
link: https://developer.okta.com/blog/2017/12/04/basic-crud-angular-and-spring-boot

@makowey