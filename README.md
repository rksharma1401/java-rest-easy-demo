# java-rest-easy-demo
java rest easy web services demo

try using 2.6 version in case of issue in eclipse or update eclipse m2e to latest

<plugin>
				<artifactId>maven-war-plugin</artifactId>
				<version>3.0.0</version>
				<configuration>
					<!-- Exclude JCL and LOG4J since all logging should go through SLF4J. 
						Note that we're excluding log4j-<version>.jar but keeping log4j-over-slf4j-<version>.jar -->
					<!-- <packagingExcludes> WEB-INF/lib/commons-logging-*.jar, %regex[WEB-INF/lib/log4j-(?!over-slf4j).*.jar] 
						</packagingExcludes> -->

					<warName>WebWS</warName>
					<!-- <outputDirectory>F:\Tools\jboss-7\jboss-eap-6.2\standalone\deployments</outputDirectory> -->
				</configuration>
</plugin>