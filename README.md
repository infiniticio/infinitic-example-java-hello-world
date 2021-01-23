# hello world app for Infinitic

The workflow `HelloWorld` will take a `name` string as input and return `"Hello $name!"` using sequentially 2 tasks run on distributed workers:

- a `sayHello` task that takes a `name` string as input and returns `"Hello $name"`
- an `addEnthusiasm` task that takes a `str` string as input and returns `"$str!"`

This repository is described in the Infinitic documentation: https://docs.infinitic.io/overview/hello-world
