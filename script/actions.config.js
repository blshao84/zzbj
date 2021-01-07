module.exports = {
    apps: [{
        name: 'csi-trans',
        script: 'java',
        args: ['-jar', '-Xms128m', '-Xmx2g', 'bin/center-1.0.jar'],
        env: {
            FILE_ANSWER_LOCATION: './answer-document',
            FILE_BASE_LOCATION: './base-document',
            FILE_ATTACHMENT_LOCATION: './attachment-document'
        }
    }]
};