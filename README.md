# lfwflogon
Simple Laserfiche logon check

## Usage
check_lflogon

Usage:
  check_lflogon -s=<server> -u=<username> -p=<password> -r=<repo>
  check_lflogon (-h | --help)

Options:
  -s --server=<server>  SQL Server Name
  -u --user=<username>  User Name
  -p --password=<password>  Password
  -r --repo=<repo>      Repo Under Test
  -h --help             Lol
  --version

## Reasoning
We needed a simple way to check if we could log into Laserfiche via a nagios or shinken script

## You will need to have access to the Laserfiche SDK (specifically the JRA-{version}.jar) in order to build
