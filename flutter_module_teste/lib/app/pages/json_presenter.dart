import 'package:flutter/material.dart';

class JsonPresenter extends StatelessWidget {
  const JsonPresenter({Key? key}) : super(key: key);

  static const String routeName = '/json-presenter';

  @override
  Widget build(BuildContext context) {
    final args =
        ModalRoute.of(context)!.settings.arguments as JsonPresenterArgs;

    return Scaffold(
      appBar: AppBar(title: const Text('Json Presenter')),
      body: Center(
        child: SingleChildScrollView(
          child: Text(
            args.json,
          ),
        ),
      ),
    );
  }
}

class JsonPresenterArgs {
  final String json;

  JsonPresenterArgs(this.json);
}
