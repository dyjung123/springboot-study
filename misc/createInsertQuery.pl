#!/usr/bin/env perl

use strict;
use warnings;

for (my $i = 3664; $i < 5664; $i++) {
    printf "INSERT INTO post (username, password, content, name) VALUES ('user%d', 'password%d', 'content%d', 'name%d');\n", $i, $i, $i, $i;
}
