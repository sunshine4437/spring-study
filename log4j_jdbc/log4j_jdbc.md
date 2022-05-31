+ log4jdbc-remix
쿼리문 출력시 prestatement ? 값을 대입해서 로그를 출력해주는 기능

pom.xml
```
<dependency>
  <groupId>org.lazyluke</groupId>
  <artifactId>log4jdbc-remix</artifactId>
  <version>${log4jdbc-remix.version}</version>
</dependency>
```
datasource-context.xml
```
<bean id="dataSource" class="net.sf.log4jdbc.og4jdbcProxyDataSource">
	<constructor-arg ref="basicDataSource"/>
	<property name="logFormatter">
		<bean class="net.sf.log4jdbc.tools.Log4JdbcCustomFormatter">
			<property name="loggingType" value="MULTI_LINE"/>
			<property name="sqlPrefix" value=""/>
		</bean>
	</property>
</bean>
```