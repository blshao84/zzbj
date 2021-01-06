module.exports = {
    apps: [{
        name: 'csi-trans',
        script: 'java',
        args: ['-jar', '-Xms128m', '-Xmx2g', 'bin/center-1.0.jar'],
        env: {
            FILE_ANSWER_LOCATION: '/home/tongyu/trans/answer-document',
            FILE_BASE_LOCATION: '/home/tongyu/trans/base-document',
            FILE_ATTACHMENT_LOCATION: '/home/tongyu/trans/attachment-document'
        }
    }]
};
