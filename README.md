totalcross-extensions
=====================

Extensions and frameworks used in TotalCross projects

Some extensions

- utils classes
- vernum - a DI framework (spring like)
- artifact repository to use TC and LB with maven in a easy way

To use this repo with maven just put this configuration in you "${user.home}/.m2/settings.xml"

    <repository>
  	   <id>github-tc-libs</id>
	   <releases>
  	      <enabled>true</enabled>
	      <checksumPolicy>fail</checksumPolicy>
	      <updatePolicy>always</updatePolicy>
	   </releases>
	   <url>https://raw.github.com/jrdalpra/totalcross-extensions/master/tc-libs/dev/mavenrepo/releases</url>
	<repository>


More is comming



[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/jrdalpra/totalcross-extensions/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

