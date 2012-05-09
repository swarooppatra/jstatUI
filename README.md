jstatUI
=======

This web application plots different graphs based on jstat

For more info on jstat please refer to - http://docs.oracle.com/javase/6/docs/technotes/tools/share/jstat.html
For more info on jstatd please refer to - http://docs.oracle.com/javase/6/docs/technotes/tools/share/jstatd.html

Softwares Used
==============

Sun JDK 6
Apache Tomcat 6
Mysql 5.5


IMPT:
=====

This project is under development. Trying to run may lead to unexpected results.

This is project has to be executed from Linux. It doesn't support Windows as of now.

Starting jstatd
================

> jstatd -J-Djava.security.policy=jstatd.all.policy

file:jstatd.all.policy
=======================
grant codebase "file:${java.home}/../lib/tools.jar" {

   permission java.security.AllPermission;

};


Using jstat command line
=======================

> jstat -class -t -h<hdr_repeat> <pid> <interval> <sample>
> jstat -gc -t -h<hdr_repeat> <pid> <interval> <sample> 