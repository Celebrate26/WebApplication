# WebApplication Pipeline Setup

This document provides instructions for setting up a CI/CD pipeline for the WebApplication project, which is a Maven-based Java application with automated UI tests.

## Overview

The pipeline will automate the build, test, and deployment processes to ensure code quality and rapid delivery.

## Prerequisites

- Java 11 or higher installed
- Maven 3.6+ installed
- A CI/CD tool such as Jenkins, GitHub Actions, or Azure DevOps
- Access to the repository

## Pipeline Configuration

### Jenkins Pipeline (Example)

If using Jenkins, create a new pipeline job and use the following script:

```groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven 3.8.1'
        jdk 'JDK 11'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-organization/WebApplication.git'
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        
        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }
        
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
    
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
```

### GitHub Actions (Example)

Create a `.github/workflows/ci.yml` file in your repository:

```yaml
name: CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: windows-latest
    
    steps:
    - uses: actions/checkout@v2
    
    - name: Set up JDK 11
      uses: actions/setup-java@v2
      with:
        java-version: '11'
        distribution: 'adopt'
    
    - name: Cache Maven packages
      uses: actions/cache@v2
      with:
        path: ~/.m2
        key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
        restore-keys: ${{ runner.os }}-m2
    
    - name: Build with Maven
      run: mvn clean compile
    
    - name: Run tests
      run: mvn test
    
    - name: Package
      run: mvn package
    
    - name: Upload test results
      uses: actions/upload-artifact@v2
      if: always()
      with:
        name: test-results
        path: target/surefire-reports/
```

## Running the Pipeline

1. Commit and push the pipeline configuration to your repository.
2. Trigger the pipeline (automatically on push/PR for GitHub Actions, or manually/build for Jenkins).
3. Monitor the build logs and test results.

## Screenshots and Reports

The tests generate screenshots in the `target/screenshots/` directory. Ensure your pipeline archives these for review.

## Deployment

For deployment, add additional stages to your pipeline, such as:
- Deploying to a staging environment
- Running integration tests
- Promoting to production

Example deployment stage (Jenkins):
```groovy
stage('Deploy to Staging') {
    steps {
        // Add deployment commands here
        bat 'echo Deploying to staging...'
    }
}
```

## Troubleshooting

- Ensure all dependencies are correctly specified in `pom.xml`.
- Check that the test environment (e.g., browser drivers for Selenium) is set up in the CI environment.
- Review test failures and screenshots for issues.
