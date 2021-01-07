#!/bin/bash
cd python
mkdir log
export PYTHONPATH=$(pwd)
cd test
echo "running smoke test ..."
eval "python test_list.py"
rc=$?; if [[ $rc != 0 ]]; then exit $rc; fi