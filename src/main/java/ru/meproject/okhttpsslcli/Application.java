package ru.meproject.okhttpsslcli;

import picocli.CommandLine;

public class Application {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new OkHttpSslCli()).execute(args);
        System.exit(exitCode);
    }
}
