# Chop Shop 166 Demo Robot

The Demo Robot uses a RoboRio 1 which has limited resources and needs extra help to run our code.


```bash
echo "vm.overcommit_memory=1" >>  /etc/syctl.conf
echo "vm.vfs_cache_pressure=1000" >> /etc/sysctl.conf
chmod a-x /usr/local/natinst/etc/init.d/systemWebServer; sync
```