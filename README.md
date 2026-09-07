# Low Level Design - Java Project

Clean Java workspace layout:

```
├── .vscode/          # VS Code project settings & launch config
├── src/              # All your Java source files (.java)
│   └── Main.java
└── bin/              # All compiled binaries (.class)
```

## How to Run

- **In VS Code:** Open [`src/Main.java`](file:///d:/System%20Design/Low%20Level%20Design/src/Main.java) and click **Run** (or press `F5`).
- **In Terminal:**
  ```powershell
  javac -d bin src/Main.java
  java -cp bin Main
  ```
