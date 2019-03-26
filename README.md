# grovvyJobStudy
## JobUtil.createJob(String jobName,String triggerName,String runTime) 封装创建任务的工具，第一个参数任务名称（唯一），第二个参数触发器名称（唯一），最后一个参数是任务运行时间，参考quartz写法。
## JobUtil.createJob(String jobName,String triggerName,String runTime，Map map)封装创建任务的工具，第一个参数任务名称（唯一），第二个参数触发器名称（唯一），第三个参数是任务运行时间，参考quartz写法，最后参数传给任务类执行方法的参数，使用参考是咧。
## GroovyJob类是任务执行类，执行方法中集成了groovy脚本运行引擎。将本demo集成到web项目中可以作为任务在线编辑系统。
