module.exports = {
    apps: [{
        name: 'csi-trans',
        script: 'java',
        args: ['-jar', '-Xms128m', '-Xmx2g', 'bin/center-1.0.jar'],
        env: {
            POSTGRES_HOST: '192.168.99.100'
        }
    }]
};