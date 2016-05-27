# oozie-tools
Examples of Oozie java actions

## Hive action
Purpose of custom Hive action is to capture output from Hive query. Also it might be useful for querying remote clusters.
### Usage:
```XML
<action name="get_max_timestamp">
   <java>
      <job-tracker>${jobTracker}</job-tracker>
      <name-node>${nameNode}</name-node>
      <main-class>mmartsen.oozie.actions.hive.GetValueFromQuery</main-class>
      <arg>${hiveServerUrl}</arg>
      <arg>${hiveUser}</arg>
      <arg>${hivePassword}</arg>
      <arg>select nvl(max(cast(timestamp_ms as bigint)),0) from default.table1</arg>
      <arg>max_timestamp</arg>
      <capture-output />
   </java>
   <ok to="process_action"/> 
   <error to="kill"/> 
</action>
```
