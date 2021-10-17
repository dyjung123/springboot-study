#!/usr/bin/env perl

use strict;
use warnings;

for (my $i = 0; $i < 26000; $i++) {
    print "INSERT INTO post (username, password, content, name) VALUES ('user%d', 'password%d', 'content%d', 'name%d')", $i, $i, $i, $i;
}
