# Publishing to Maven Central

This guide explains how to publish JUtils to Maven Central via Sonatype OSS Repository Hosting.

## Prerequisites

1. **Sonatype Account**: Register at [Sonatype Jira](https://issues.sonatype.org/browse/OSSRH)
   - Create a Jira ticket to request namespace for `com.sel2in`
   - Wait for approval (usually within a few hours)

2. **GPG Setup**: Generate a GPG key pair
   ```bash
   gpg --gen-key
   gpg --list-keys
   gpg --keyserver hkp://keys.openpgp.org --send-keys YOUR_KEY_ID
   ```

3. **Maven Settings**: Configure Maven with your Sonatype credentials
   - Copy `settings.xml.template` to `~/.m2/settings.xml`
   - Add your Sonatype username and password
   - Alternatively, use environment variables:
     ```bash
     export MAVEN_OPTS="-Dsonatype.username=YOUR_USERNAME -Dsonatype.password=YOUR_PASSWORD"
     ```

## Publishing Steps

### 1. Update Version.
Edit `pom.xml` and update the version:
```xml
<version>0.0.5</version>
```

### 2. Create Release Tag
```bash
git tag -a v0.0.5 -m "Release version 0.0.5"
git push origin v0.0.5
```

### 3. Build and Sign
```bash
mvn clean package
```

### 4. Prepare Release
```bash
mvn release:prepare
```

### 5. Perform Release
```bash
mvn release:perform
```

### 6. Manual Staging (Alternative)

If automated release fails:

```bash
# Deploy to staging repository
mvn clean deploy -P release

# Login to Sonatype UI
# Navigate to Staging Repositories
# Find your repository
# Close and Release the repository
```

## Post-Publication

1. **Verify Publication**: Check [Maven Central Search](https://central.sonatype.com/search)
2. **Update Documentation**: Update version in README.md

## Troubleshooting

### GPG Issues
- Ensure GPG is installed: `gpg --version`
- Check GPG configuration in `pom.xml`
- May need to add `gpg.passphrase` to Maven settings

### Sonatype Issues
- Check staging repository logs in Sonatype UI
- Common issues: missing signatures, incorrect namespacing
- Review [Sonatype Guide](https://central.sonatype.org/publish/publish-portal-guide/)

### Maven Issues
```bash
# Clean build
mvn clean install

# Verbose output for debugging
mvn -X clean deploy
```

## References

- [Sonatype Maven Central Publishing Guide](https://central.sonatype.org/publish/publish-portal-guide/)
- [Working with PGP Signatures](https://central.sonatype.org/publish/requirements/gpg/)
- [Maven Release Plugin](https://maven.apache.org/maven-release/maven-release-plugin/)
