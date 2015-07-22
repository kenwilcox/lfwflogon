package com.medamericabilling.nagios;

import com.laserfiche.repositoryaccess.*;
import java.util.Map;
import java.util.Scanner;

import org.docopt.Docopt;

public class Main {

    public static void main(String[] args) {
        try {
            String help;
            try(Scanner scanner = new Scanner(Main.class.getResourceAsStream("help.txt"), "UTF-8").useDelimiter("\\A")) {
                help = scanner.next();
            }
            Map<String, Object> opts = new Docopt(help).withVersion("lflogon 0.1.0").parse(args);
            System.out.println(opts);

            String serverName = (String)opts.get("--server");
            String repoName = (String)opts.get("--repo");
            String userName = (String)opts.get("--user");
            String password = (String)opts.get("--password");

            int port = 80;

            // Create a new session
            Session session = new Session();

            // Specify the repository to log in to
            RepositoryRegistration repository = new RepositoryRegistration(serverName, repoName, port);

            // Connect to the specified repository
            session.connect(repository);

            // Log in using Laserfiche authentication
            session.logIn(userName, password);

            // Log out of the repository
            session.logOut();
            System.out.println("Looks good");
            System.exit(0);
        } catch (Exception e) {
            System.err.print(e.getMessage());
            System.exit(2);
        }
    }
}
