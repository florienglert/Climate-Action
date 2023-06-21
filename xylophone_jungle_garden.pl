#!/usr/bin/perl

# Load various Perl modules
use strict;
use warnings;
use Term::ANSIColor;

# Set the climate action goal
my $goal="reduce carbon emissions in the atmosphere";

# Define a subroutine to inform user of the goal
sub climate_action_info {
  print color('bold green');
  print "Our goal is to $goal.\n";
  print color('reset');
}

# Prompt user for input
print "What would you like to do to help meet this goal?\n";
my $user_input = <STDIN>;

# Perform an action based on the user input
if ($user_input =~ /turn off lights/i) {
  print "Turning off lights can help reduce energy consumption.\n";
  &climate_action_info;
} elsif ($user_input =~ /bike/i) {
  print "Biking is a great way to reduce carbon emissions.\n";
  &climate_action_info;
} elsif ($user_input =~ /conserve water/i) {
  print "Conserving water helps to reduce energy consumption.\n";
  &climate_action_info;
} elsif ($user_input =~ /buy electric car/i) {
  print "Electric cars are a great way to reduce emissions.\n";
  &climate_action_info;
} elsif ($user_input =~ /plant trees/i) {
  print "Planting trees helps to absorb carbon dioxide.\n";
  &climate_action_info;
} else {
  print "I'm not sure how that would help us meet our goal.\n";
  &climate_action_info;
}