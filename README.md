# Crawler-API- Pet project

## Purposes:
 - Write an effective, clean, scalable, and 'user-friendly' crawler-api
 - without popular dependencies, only pure java.
 - And practice API writing. :)
 
## MVP1:
  - Define package structure and implement basic logic.
  - Use only one specific implementation, without Generic!
  - Handle possible exceptions and errors.
  - Define different modules

### Refactor opportunities:
  1. FieldSelector#execute has to know about JSOUP?
     - It's less generic, harder to modify crawler implementation, because selector module know 
     about JSOUP

 