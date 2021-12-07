<h1>lecture-21</h1>

<p>Home task lecture 21:</p>
<ol>
<li>Git repo and best practices</li>
<li>base on #20</li>
<li>add DAO and hibernate tiers with spring integration</li>
<li>All configurations in Java code (don't use xml)</li>
<li>deploy to servlet container per student</li>
</ol>


<h2>What's done:</h2>
<ol>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
</ol>

<h3>To run App you should:</h3>
<ol>
<li>Build project: $mvn clean install</li>
<li>Run new postgresql server for the App: $docker-compose up -d</li>
<li>Run liquibase to create tables and insert data:</li>
	<ol>
		<li>$cd persistence</li>
		<li>$mvn liquibase:update</li>
	</ol>
<li>Run App on server mapped on /goods</li>
</ol>