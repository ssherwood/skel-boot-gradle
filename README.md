# Experimental

Gradle multi-module application and component project to support alternative
packaging methodologies.

## Overview

This project is heavily inspired by the discussion started during the Pivotal
Platform Acceleration Labs exercises via the [Application Continuum](http://www.appcontinuum.io/)
project.  The theory being that by applying these ideas, we will end up with
better application architecture(s).

## Goals

My goals are limited to exploring alternative ways of thinking about
application architecture including organization and composition of components.
As this is somewhat controversial and could be considered an example of
premature optimization, it does seems worthy of deeper exploration.

## Observations

Personally, I am not completely sold on all of the ideas presented in the App
Continuum/PAL.  This project is for my personal experimentation with those concepts
so I can refine, explore and (hopefully) improve on over time.

Additionally, my general concerns are as follows:

1. The organization prescribed is a bit foreign to most developers and requires
some exposure before becoming comfortable with the overall layout.
2. The idea of including multiple "applications" is a clear violation of the
1st factor of [12-Factor apps](https://12factor.net/codebase):
 
```
Multiple apps sharing the same code is a violation of twelve-factor
```

