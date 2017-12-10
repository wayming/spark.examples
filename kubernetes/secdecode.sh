kubectl get secret regsecret --output=yaml | grep dockercfg: | sed -e "s#  .dockercfg: ##g" | base64 -d 
