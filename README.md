# Isarithm Account
Account Java Spring REST web service for Isarithm

## Installation
```bash
    $ git clone https://github.com/matthewpoletin/isarithm-account.git
    $ cd isarithm-account
    $ gradle bootJar
    $ scp ./build/libs/isarithm-account.jar isarithm@vds1.isarithm.ru:/var/www/isarithm/isarithm-account.jar
    $ ssh -f isarithm@vds1.isarithm.ru 'nohup java -Dserver.port=4001 -jar /var/www/isarithm/isarithm-account.jar --spring.profiles.active=prod >/dev/null 2>&1 &'
```

## Restart
```fish
    ssh -f isarithm@vds1.isarithm.ru 'kill -15 (ps aux | grep 'isarithm-account.jar' | grep -v grep | awk \'{print $2}\')'
```
