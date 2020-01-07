import sun.security.tools.PathList

name := "firstSBT"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.1.1"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.1.1"



//resolvers ++= Seq(
//  "apache-snapshots" at "http://repository.apache.org/snapshots/"
//)

//libraryDependencies ++= Seq(
//  "org.apache.spark" %% "spark-core" % "1.2.1"

//libraryDependencies ++= Seq(
//  "org.apache.spark" %% "spark-core_2.11" % "2.1.1",
//  "org.apache.spark" %% "spark-sql_2.11" % "2.1.1")

//libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.1.0"


//libraryDependencies ++= Seq(
//  "org.apache.spark" % "spark-core_2.11" % "2.2.0",
//  "org.apache.spark" % "spark-sql_2.11" % "2.2.0",
////  "org.apache.spark" % "spark-mllib_2.10" % "1.1.0"
//)