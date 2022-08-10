package ru.meproject.okhttpsslcli;

import org.fabiomsr.peercertificate.PeerCertificateExtractor;
import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "okhttpsslcli", description = "Extract SSL certificate SHA-256 hash for SSL Pinning using OkHttp library")
public class OkHttpSslCli implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", paramLabel = "CERTIFICATE",
            description = "Certificate file to extract from. Supported formats: .crt .der and .pem")
    private File file;

    @CommandLine.Option(names = {"--accept-license", "-al"},
            description = "Accept this okhttpsslcli license so it won't be shown when extracting certificate")
    private boolean acceptLicense;


    @Override
    public Integer call() throws Exception {
        if (!acceptLicense) {
            System.out.println("""
                !!! WARNING !!!
                
                This software itself is MIT licensed but it uses code from
                Peer certificate extractor (https://github.com/fabiomsr/okhttp-peer-certificate-extractor)
                which is licensed under following copyright
                
                ***
                Copyright 2016 Fabio Santana (fabiomsr)
                                
                Licensed under the Apache License, Version 2.0 (the "License");
                you may not use this file except in compliance with the License.
                You may obtain a copy of the License at
                                
                   http://www.apache.org/licenses/LICENSE-2.0
                                
                Unless required by applicable law or agreed to in writing, software
                distributed under the License is distributed on an "AS IS" BASIS,
                WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                See the License for the specific language governing permissions and
                limitations under the License.
                ***
                """);
        }
        System.out.println(PeerCertificateExtractor.extract(file));
        return 0;
    }
}
