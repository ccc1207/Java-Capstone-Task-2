FROM openjdk:11
WORKDIR /app

# Copy source code
COPY src/ /app/src/

# Create bin directory
RUN mkdir -p /app/bin

# Find and compile all Java files
RUN find /app/src -name "*.java" > sources.txt && javac -d /app/bin @sources.txt

# Run the application with the package name
CMD ["java", "-cp", "/app/bin", "quickFoodCopy.QuickFoodCopy"]
