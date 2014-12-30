##Gradle Scratch Space
[Gradle in Action](http://www.manning.com/muschko/)

####Eclipse
* Cannot find references (**F3**) for Gradle build files

####Intellij
* Can find references (***F3***) but needs some help the respective Gradle and Groovy sources have to provided
* It also interesting to note the the size of the library doesn't seem to affect the performance of Intellij, as in exclusively adding in the Gradle core located in gradle/src/core or the Groovy core located in groovy/src/src/main vs adding in the root folder (gradle/groovy) or the src folder (gradle/src or groovy/src), Intellij simply scans and finds the sources
* Is able to find Gradle's buildSrc as long as it's included as a module, however it seems to have some issues with groovy source as it marks all the classes as already existing
    
####Gradle

    task 'myTask' {} //is the same as
    Project.task('myTask', {}) // this
    
However Gradle uses [AST transformations](http://groovy.codehaus.org/Compile-time+Metaprogramming+-+AST+Transformations) to convert

    task myTask(){}
    Project.task('myTask', {}) //the same as the above
    
See the stackoverflow post [here](http://stackoverflow.com/questions/27584463/understing-the-groovy-syntax-in-a-gradle-task-definition/27584555) for more information
    
    
####Todo
* Push IDEA and Eclipse settings