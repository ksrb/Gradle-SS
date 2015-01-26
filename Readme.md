##Gradle Scratch Space

###Books
* [Gradle in Action](http://www.manning.com/muschko/)

###Workspace

####Eclipse
* Cannot find references (<b>F3</b>) for Gradle build files

####Intellij
Can find references (<b>F3</b>) but needs the respective Gradle and Groovy sources to configure follow these steps in Intellij:

<ol> 
<li><b>Ctrl+Alt+Shift+S</b></li>
<li>On the sidebar click <b>Global Libraries</b></li>
<li>Click <b>+ &rarr; Library</b></li>
<li>Navigate to Gradle sources add
	<ul>
	<li><b>[gradleDir]</b>/lib/*.jar's but exclude groovy-all-*.jar</li>
	<li><b>[gradleDir]</b>/lib/plugins/*.jar's</li>
	<li><b>[gradleDir]</b>/src/</li>
	<li><b>[gradleDir]</b>/src/docs/javadoc</li>
	</ul>
</li>
<li>Name the lib gradle-[version] and press <b>Okay</b>
<li>Navigate to Groovy source add
	<ul>
	<li><b>[groovyDir]</b>/lib</li>
	<li><b>[groovyDir]</b>/src/src/main</li>
	<li><b>[groovyDir]</b>/doc/html/api</li>
	</ul>
</li>
</ol>
So after some experimentation in Intellij it seems that as long as you create a new project via <b>New Project &rarr; Gradle</b> with these Global Libraries available Intellij will automatically be able to find references.

Meaning it is unnecessary to have your project use these libraries as dependencies via <b>Ctrl+Alt+Shift+S &rarr; Modules &rarr; Libraries</b>

#####buildSrc
As long as you create a using <b>New Project &rarr; Gradle</b> the code in the buildSrc can automatically be referenced standard directory structure should probably be followed buildSrc/main/groovy/[your code]

Some cleanup of Intellij default Gradle project settings may be necessary:

* Removing the JUnit libs
* Changing <b>Project language level</b>

###Gradle

    task 'myTask' {} //is the same as
    Project.task('myTask', {}) // this
    
However Gradle uses [AST transformations](http://groovy.codehaus.org/Compile-time+Metaprogramming+-+AST+Transformations) to convert

    task myTask(){}
    Project.task('myTask', {}) //the same as the above
    
See the stackoverflow post [here](http://stackoverflow.com/questions/27584463/understing-the-groovy-syntax-in-a-gradle-task-definition/27584555) for more information