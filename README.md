# grails-sandbox

Steps to get here:

    download from https://grails.org/download.html
    $ sudo mkdir -p /opt
    $ sudo mv grails-3.2.4/ /opt
    $ vi ~/.profile
    $ grep PATH ~/.profile
    export PATH=/usr/local/bin:/usr/local/sbin:/usr/bin:$PATH:/opt/grails-3.2.4/bin
    $ . ~/.profile
    $ cd ~/src/grails-sandbox/

    ### i needed this due to a bug in my current installed JVM
    $ export GRAILS_OPTS="-XX:-UseSplitVerifier -Xverify:none"

    $ grails create-app --inplace --profile angular
    | Application created at /Users/mdriscoll/src/grails-sandbox
    $ grails run-app
    Grails application running at http://localhost:8080 in environment: development
