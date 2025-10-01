# SpringBoot Java Template


This is not the best structure. This is a good basic structure to use early in the project when productivity is important.

Remember, as your software grows, your structure must grow too.

# **Modules**

## Core
Each submodule of this module is responsible for one domain service.

This must make the modular structure grow with the growth of the service.

### core:core-api
It is the only executable module in the project. It is structured to have domains to maximize initial development productivity.

It is also responsible for providing APIs and setting up frameworks for services.

### core:core-enum

This module contains enums that are used by `core-api` and must be delivered to external modules.

<br/>

## Clients
Submodules of this module are responsible for integrating with external systems.

### clients:clients-example
This module shows an example of HTTP communication with `Spring-Cloud-Open-Feign`.

<br/>

## Storage
Submodules of this module are responsible for integrating with the various storages.

<br/>

## Support
Submodules of this module are responsible for additional support.

### support:logging
This module supports logging of service and has a dependency added for distributed tracing support.

It also includes dependencies to support `Sentry`.

### support:monitoring
This module supports monitoring of services.

<br/>

## Tests
Submodules of this module are responsible for the convenience of writing test codes.

### tests:api-docs
This module is for writing spring-rest-docs conveniently.

<br/>

# Dependency Management
All dependency versioning is done through `gradle.properties` file.

If you want to add a new dependency, put the version in `gradle.properties` and load it in `build.gradle`.

<br/>

# Runtime Profiles

## local
This profile aims to configure an environment that can be developed even if the network is disconnected.

## local-dev
This profile aims configurations that allow me to connect to the DEV environment from my local machine.

## dev
This profile exists for deploying Development environments.

## staging
This profile exists for deploying Staging environments.

## live
This profile exists for deploying Live environments.

<br/>

# Test Tasks & Tags

## test
This is a collection of test-tasks that we want to run on `CI`.

If you want to change the settings, modify the `build.gradle` file.

## unitTest
This is a group of tests that typically have no dependencies, are fast to run, and test a single feature.

## contextTest
This is a task that runs with SpringContext and has integration tests.

## restDocsTest
This is a task to create asciidoc based on spring-rest-docs.

## developTest
This is a task of tests that should not be run in `CI`.

This is a good tag to use if you're not good at writing tests.

<br/>

# Recommended Preferences

## Git Hook
This setting makes run `lint` on every commit.

```
$ git config core.hookspath .githooks
```

## IntelliJ IDEA
This setting makes it easier to run the `test code` out of the box.

```
// Gradle Build and run with IntelliJ IDEA
Build, Execution, Deployment > Build Tools > Gradle > Run tests using > IntelliJ IDEA	
```

If you want to apply lint settings to the format of IDEA, please refer to the guide below.

[Spring Java Format IntelliJ IDEA](https://github.com/spring-io/spring-javaformat#intellij-idea)

