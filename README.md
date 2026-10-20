# JUtils

Java utility libraries for common operations.

## Overview

JUtils provides reusable Java utilities for file operations and other common tasks.

## Features

- File filtering utilities
- Additional utilities coming soon

## Installation

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.sel2in</groupId>
    <artifactId>jutils</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```gradle
implementation 'com.sel2in:jutils:1.0.0'
```

## Usage

### FileNameEndsWithFilter

Filter files by their names:

```java
import com.sel2in.jutils.io.FileNameEndsWithFilter;
import java.io.File;

// Create a filter for files ending with ".txt"
FileNameEndsWithFilter filter = new FileNameEndsWithFilter(".txt", false);

// Use with File.listFiles()
File dir = new File("/path/to/directory");
File[] txtFiles = dir.listFiles(filter);

// To include directories also
FileNameEndsWithFilter filterWithDirs = new FileNameEndsWithFilter(".txt", true);
File[] txtFilesAndDirs = dir.listFiles(filterWithDirs);
```

## Requirements

- Java 1.8 or higher
- Maven 3.6.0 or higher (for building)

## License

MIT License - see LICENSE file for details

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Author

[tgkprog](https://github.com/tgkprog)

## Repository

[https://github.com/tgkprog/jutils](https://github.com/tgkprog/jutils)
